pipeline {
  agent {
    kubernetes {
      yaml '''
        apiVersion: v1
        kind: Pod
        spec:
          containers:
          - name: maven
            image: maven:alpine
            command:
            - cat
            tty: true
        '''
    }
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
                    kubectl create namespace busybox
                    kubectl create -f busybox.yaml -n busybox
                    """
                }
            }
        }
    }
}
