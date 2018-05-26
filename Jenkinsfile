pipeline {
agent any
stages {
	        stage('Clone repository') {
	                /* Let's make sure we have the repository cloned to our workspace */
	            steps{
	            checkout scm
	            }
	        }
	        stage('clean build'){
		        steps{
		                  clean_build_step()
		        }
			}
		}
}

def clean_build_step()
{
	shell('mvn clean install')
}

def shell(command) {
    return bat(returnStdout: true, script: "${command}").trim()
}