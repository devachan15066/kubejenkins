pipeline {
    agent any

    environment {
        KUBECONFIG = credentials('clusterconfig')
    }

    stages {
        stage('Deploy') {
            steps {
                script {
                    sh """
                    export KUBECONFIG=$KUBECONFIG
                    kubectl apply -f nginx.yaml
                    """
                }
            }
        }
    }
}
