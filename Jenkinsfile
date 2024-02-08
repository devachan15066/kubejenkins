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
        stage('Install kubectl') {
          steps {
            script {
              sh 'curl -LO https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/stable.txt)/bin/linux/amd64/kubectl && chmod +x kubectl && sudo mv kubectl /usr/local/bin'
            }
          }
        }
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
