node {
    stage 'Checkout'
        git url: 'https://github.com/emcconsulting/spring-petclinic.git'
        def mvnHome = tool 'M3'
        //input 'Ready to go?'
    stage 'Build'
        //env.PATH = "${mvnHome}/bin:${env.PATH}"
        sh "${mvnHome}/bin/mvn -B verify -Dmaven.test.failure.ignore"
        step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
}