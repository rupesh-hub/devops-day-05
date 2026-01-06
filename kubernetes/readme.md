```shell
kubectl apply -f namespace.yaml
kubectl get namespaces
```

```shell
kubectl apply -f deployment.yaml
kubectl get pods -n devops -w
kubectl get deployment -n devops
```

```shell
kubectl apply -f backend.yaml
kubectl get svc -n backend-svc
kubectl get pods -n devops
kubectl port-forward svc/backend-svc 8181:8181 -n devops --address=0.0.0.0
```