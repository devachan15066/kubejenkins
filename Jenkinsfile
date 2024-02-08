pipeline {
    agent {
        kubernetes
    }
    environment {
        KUBECONFIG = credentials('clusterconfig')
    }
    stages {
        stage('Deploy') {
            steps {
                script {
                    sh """
                    #!/bin/bash
                    export KUBECONFIG=$KUBECONFIG
                    kubectl apply -f busybox.yaml
                    """
                }
            }
        }
    }
}
