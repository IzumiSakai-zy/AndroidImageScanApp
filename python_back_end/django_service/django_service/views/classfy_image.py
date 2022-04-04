
from django.http import JsonResponse
from .classfication import test
import os


def classify_image(request):
    image = request.FILES.get('image')
    file_path = './image.png'
    if os.path.exists(file_path):
        os.remove(file_path)
    with open(file_path, 'wb') as fp:
        for chunk in image.chunks():
            fp.write(chunk)
    result = test.test_a_image()
    response_date = {
        'class_type': result
    }
    return JsonResponse(response_date)
