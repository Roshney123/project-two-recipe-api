pipeline {
  environment {
    registry = 'darylnauman/project2'
    dockerHubCreds = 'docker_hub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Test') {
      steps {
        sh 'echo "Hello, World! Recipe API"'
      }
    }
    stage('Unit Testing') {
        when {
            // anyOf {branch 'ft_*'; branch 'bg_*'} -- UPDATE
            branch 'ft_jenkins'
        }
        steps {
            withMaven {
                sh 'mvn test'
            }
            junit skipPublishingChecks: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
    stage('Build') {
        when {
            // branch 'main' -- UPDATE
            branch 'ft_jenkins'
        }
        steps{
            withMaven {
                sh 'mvn package -DskipTests'
            }
        }
    }
    stage('Docker Image') {
        when {
            // branch 'main' - UPDATE
            branch 'ft_jenkins'
        }
        steps{
            script {
                echo "$registry:$currentBuild.number"
                dockerImage = docker.build "$registry:$currentBuild.number"
            }
        }
    }
  }
}