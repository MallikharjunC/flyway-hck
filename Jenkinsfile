pipeline {
    agent any
    tools {
            maven 'maven-3.8.4'
        }
    stages {
        stage ('Compile Stage') {
            steps {
                sh 'mvn clean package'
            }
        }
    }

}
