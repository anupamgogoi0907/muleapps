# Shor Cuts
```
alias k="kubectl"
alias kget="kubectl get"
alias kdesc="kubectl describe"
alias kdelete="kubectl delete"
alias klogs="kubectl logs -f"
alias kexec="kubectl exec -it"
```
# References
## Install Kubernetes in Ubuntu
https://blog.radwell.codes/2021/05/provisioning-single-node-kubernetes-cluster-using-kubeadm-on-ubuntu-20-04/

# TroubleShooting
### Taint: 
```
kubectl taint node master node-role.kubernetes.io/master:NoSchedule-
```
### Swap Off
