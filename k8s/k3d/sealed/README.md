# Sealed Secrets

References:

https://github.com/bitnami-labs/sealed-secrets
https://docs.d2iq.com/dkp/dispatch/1.3/tutorials/cd_tutorials/storing-dispatch-secrets-with-gitops/
https://imsharadmishra.medium.com/exploring-sealed-secrets-in-minikube-7f517799413c
https://developer.okta.com/blog/2021/06/01/kubernetes-spring-boot-jhipster

```bash
helm repo add sealed-secrets https://bitnami-labs.github.io/sealed-secrets
helm install sealed-secrets sealed-secrets/sealed-secrets
```

For more details please check the installation scripts in `/scripts`
