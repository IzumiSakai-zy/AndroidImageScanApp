package com.whu.androidimagescanapp.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.viewpager2.widget.ViewPager2
import com.whu.androidimagescanapp.R
import com.whu.androidimagescanapp.adapter.MainContainerViewPageAdapter
import com.whu.androidimagescanapp.utils.CommonUtils
import com.whu.androidimagescanapp.utils.PermissionUtil
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainContainerFragment : Fragment(), View.OnClickListener {

    private var viewpager2:ViewPager2? = null

    private var imageLibraryIcon:ImageView? = null
    private var searchIcon:ImageView? = null
    private var takeImageIcon: ImageView? = null
    private var homeIcon:ImageView? = null
    private var mySelfIcon:ImageView? = null


    private var viewPageAdapter:MainContainerViewPageAdapter? = null
    private var imageUri: Uri? = null

    companion object {
        const val TAG = "main_container_fragment"
        private const val REQUEST_STORAGE_PERMISSION = 1
        private const val TAKE_A_PHOTO = 2

        @JvmStatic
        fun newInstance() = MainContainerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_container, container, false).let {
            viewpager2 = it.findViewById(R.id.main_container_viewPager)

            imageLibraryIcon = it.findViewById(R.id.bottom_icon_image_library)
            searchIcon = it.findViewById(R.id.bottom_icon_search)
            takeImageIcon = it.findViewById(R.id.bottom_icon_take_a_photo)
            homeIcon = it.findViewById(R.id.bottom_icon_home)
            mySelfIcon = it.findViewById(R.id.bottom_icon_myself)

            it
        }
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainContainerViewPageAdapter(requireActivity()).apply {
            viewPageAdapter = this
            viewpager2?.adapter = this
        }

        imageLibraryIcon?.setOnClickListener(this)
        searchIcon?.setOnClickListener(this)
        takeImageIcon?.setOnClickListener(this)
        homeIcon?.setOnClickListener(this)
        mySelfIcon?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val clickedView = view ?: return
        when (clickedView.id) {
            R.id.bottom_icon_image_library -> {

            }
            R.id.bottom_icon_search -> {
                viewpager2?.currentItem = MainContainerViewPageAdapter.SEARCH_PAGE_INDEX
            }
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
            R.id.bottom_icon_home -> {
                viewpager2?.currentItem = MainContainerViewPageAdapter.HOME_PAGE_INDEX
            }
            R.id.bottom_icon_myself -> {
                viewpager2?.currentItem = MainContainerViewPageAdapter.MY_SELF_PAGE_INDEX
            }
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_A_PHOTO) {
            val uri = imageUri ?: return
            BitmapFactory.decodeStream(activity?.contentResolver?.openInputStream(uri)).let {
                viewPageAdapter?.getHomePageFragmentScannedView()?.apply {
                    val pixValue = CommonUtils.dip2px(requireContext(), 10)
                    setPadding(pixValue,0,pixValue,0)
                    setImageBitmap(it)
                }
            }
            viewpager2?.currentItem = MainContainerViewPageAdapter.HOME_PAGE_INDEX
        }
    }
}