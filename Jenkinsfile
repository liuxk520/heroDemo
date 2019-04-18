node {
    checkout scm
    stage('Test') {
        sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent test'
    }
    stage('Sonar') {
        sh 'mvn sonar:sonar'
    }
    stage('Package') {
        sh 'mvn clean package -Dmaven.test.skip=true'
    }
    stage('Deploy') {
        sh "./deploy.sh"
    }
}

