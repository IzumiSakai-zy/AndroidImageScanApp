from django.http import HttpResponse
import os


def hello_world(request):
    return HttpResponse(os.path.abspath('./'))
