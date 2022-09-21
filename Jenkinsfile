pipeline {
    agent any
    tools {
            maven 'MAVEN_HOME'
        }
    stages {
        stage ('Compile Stage') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }

}
