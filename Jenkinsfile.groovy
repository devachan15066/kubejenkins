pipeline {
    agent any

    stages {
        stage('Deploy Nginx') {
            steps {
                script {
                    // Define the YAML for the Nginx pod
                    def nginxPodYaml = """
                    apiVersion: v1
                    kind: Pod
                    metadata:
                      name: nginx-pod
                    spec:
                      containers:
                      - name: nginx-container
                        image: nginx
                        ports:
                        - containerPort: 80
                    """
                    
                    // Deploy the pod
                    deployToKubernetes(namespace: 'jenkins', yaml: nginxPodYaml)
                }
            }
        }
    }
}

// Function to deploy YAML to Kubernetes
def deployToKubernetes(def namespace, def yaml) {
    try {
        sh "echo '${yaml}' | kubectl apply -f - --namespace=${namespace}"
    } catch (err) {
        error "Failed to deploy to Kubernetes: ${err}"
    }
}