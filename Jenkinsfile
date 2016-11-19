#!groovy

node {
    // Mark the code checkout 'stage'....
    stage 'Checkout'

    // Checkout code from repository
    checkout scm

    // Mark the code build 'stage'....
    stage 'Build'

    def mvnHome = tool 'mvn'
    bat "${mvnHome}/bin/mvn clean verify"
}

