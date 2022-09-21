pipeline {
    agent any
    tools {
            maven 'Maven 3.2.5'
        }
    stages {
        stage ('Compile Stage') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }

}
