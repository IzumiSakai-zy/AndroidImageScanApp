from django.http import HttpResponse

from .classfication import test


def classfy_image(request):
    image = request.FILES.get('image')
    with open('./image.png', 'wb') as fp:
        for chunk in image.chunks():
            fp.write(chunk)
    result = test.test_a_image()
    return HttpResponse(result)
