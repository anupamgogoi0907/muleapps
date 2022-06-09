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

## Install Minishift in Ubuntu 20,04
https://medium.com/@balashanmugam2016/how-to-install-openshift-minishift-in-ubuntu-20-04-using-virtualbox-as-hypervisor-6adbd0092563

# TroubleShooting
### Taint: 
```
kdesc nodes k8s | grep Taints
kubectl taint node master node-role.kubernetes.io/master:NoSchedule-
```
### Swap Off
