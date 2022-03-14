import torch
import torchvision.transforms as transforms
from .resnet import ResNet18
import cv2

# tags of cifar-10
classes = ('plane', 'car', 'bird', 'cat', 'deer', 'dog', 'frog', 'horse', 'ship', 'truck')

# define model - ResNet
net = ResNet18()
# load trained model parameters
net.load_state_dict(torch.load('./pytorch_model/net_130.pth'))
net.eval()


# we use a 4d tensor(100 * 3 * 32 * 32'batch_size * chanel * height * width') to train our model.
# so we firstly need to transform an input image to a 4d tensor
def get_image_tensor(image_path):
    img = cv2.imread(image_path)
    trans_f = transforms.Compose([
        transforms.ToTensor(),
        # same Normalization during training
        transforms.Normalize((0.4914, 0.4822, 0.4465), (0.2023, 0.1994, 0.2010))
    ])
    # reshape to (1 * 3 * 32 * 32), and our batch_size is 1
    img_tensor_4d = trans_f(img).reshape(1, 3, 32, 32)
    print(img_tensor_4d.size())
    return img_tensor_4d


def test_a_image():
    with torch.no_grad():
        image_tensor = get_image_tensor('./image.png')
        # use model with parameters to evaluate the input image tensor
        outputs = net(image_tensor)
        _, predicted = torch.max(outputs.data, 1)
        result = int(predicted[0].item())
        print(result)
        return str(result)
