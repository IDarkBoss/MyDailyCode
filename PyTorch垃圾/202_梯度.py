import torch

tensor = torch.Tensor([[1, 2], [3, 4]])
tensor.requires_grad = True

t_out = torch.mean(tensor * tensor)
t_out.backward()
print(tensor.grad)
