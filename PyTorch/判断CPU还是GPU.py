import torch

result = torch.cuda.is_available()
if result is True:
    print("GPU")
else:
    print("CPU")
