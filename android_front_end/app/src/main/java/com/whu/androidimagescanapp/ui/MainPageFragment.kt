package com.whu.androidimagescanapp.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.utils.CommonUtils
import com.whu.androidimagescanapp.utils.PermissionUtil
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainPageFragment : Fragment(), View.OnClickListener {

    companion object {
        const val TAG = "MAIN_PAGE_FRAGMENT"

        @JvmStatic
        fun newInstance() = MainPageFragment()
    }

    private val REQUEST_STORAGE_PERMISSION = 1
    private val TAKE_A_PHOTO = 2

    private var takeImage: ImageView? = null
    private var scannedImage: ImageView? = null
    private var imageUri: Uri? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        takeImage?.apply {
            setOnClickListener(this@MainPageFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_page, container, false).let {
            takeImage = it.findViewById(R.id.bottom_icon_take_a_photo)
            scannedImage = it.findViewById(R.id.main_page_scanned_image)
            it
        }
    }

    override fun onClick(view: View?) {
        val clickedView = view ?: return
        when (clickedView.id) {
            R.id.bottom_icon_take_a_photo -> {
                if (PermissionUtil.checkPermission(
                        requireContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                ) {
                    requestCamera()
                } else {
                    requestStoragePermission()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
            && requestCode == REQUEST_STORAGE_PERMISSION
        ) {
            requestCamera()
        } else {
            Toast.makeText(requireContext(), "请授予存储权限后再试", Toast.LENGTH_LONG).show()
        }
    }

    private fun requestStoragePermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            REQUEST_STORAGE_PERMISSION
        )
    }

    private fun requestCamera() {
        imageUri = FileProvider.getUriForFile(requireContext(), "com.whu.fileprovider", getImageFile())
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        startActivityForResult(intent, TAKE_A_PHOTO)
    }

    private fun getImageFile(): File {
        val imageName = "JPEG_${SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())}_"
        val storageDir = requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(imageName, ".jpeg", storageDir)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_A_PHOTO) {
            val uri = imageUri ?: return
            BitmapFactory.decodeStream(activity?.contentResolver?.openInputStream(uri)).let {
                scannedImage?.apply {
                    val pixValue = CommonUtils.dip2px(requireContext(), 10)
                    setPadding(pixValue,0,pixValue,0)
                    setImageBitmap(it)
                }
            }
        }
    }
}