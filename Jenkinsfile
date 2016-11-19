#!groovy

node {
    // Mark the code checkout 'stage'....
    stage 'Checkout'

    // Checkout code from repository
    checkout scm

    // Mark the code build 'stage'....
    stage 'Build'

    def mvnHome = tool 'M3'
    env.PATH = "${mvnHome}/bin:${env.PATH}"
    sh 'mvn clean verify'
}

