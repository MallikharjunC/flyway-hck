pipeline {
    agent any
    tools {
            maven 'Maven'
        }
    stages {
        stage ('Compile Stage') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }

}
