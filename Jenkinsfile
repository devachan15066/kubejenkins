pipeline {
    agent {
      kubernetes    
    environment {
        KUBECONFIG = credentials('clusterconfig')
    }

    stages {
        stage('Deploy') {
            steps {
                script {
                    sh """
                    export KUBECONFIG=$KUBECONFIG
                    kubectl apply -f busybox.yaml
                    """
                }
            }
        }
    }
}
