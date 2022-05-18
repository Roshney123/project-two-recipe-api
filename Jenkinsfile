pipeline {
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
  }
}