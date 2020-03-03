# Deployment

This document outlines...

## Deploying from scratch 

1. Create an Ubuntu instance
    1. Go to the AWS Lightsail Console 
    1. Create a new instance
    1. OS Only - Ubuntu
    1. Select an instance with at least...
        1. 1 GB RAM
        1. 1 vCPU
        1. 40 GB SSD
        1. Identify the instance

1. Connect to the instance

1. Create a new user and group (danielkeane)

    `sudo adduser danielkeane`

1. Add the user to the sudo group

    `usermod -aG sudo danielkeane`
    
1. Switch to that user

    `sudo su - danielkeane`
    
1. Setup SSh
    1. Copy the authorized_keys to the new user
    
        `sudp cp /home/ubuntu/.ssh/authorized_keys /home/danielkeane/.ssh/authorized_keys`
    
    1. Copy your private Github SSH certificate to ~/.ssh/id_rsa
    1. Add the private key to the OpenSSH client (for Github connection)
        1. 
    
1. Create and enter a new directory "/app"
    1. Make it yours
    
        `sudo chown danielkeane:danielkeane /app`

1. Clone the repository
    
    `git clone git@github.com:clincha/DanielKeane.git`
    
1. Build and test
    1. Enter the DanielKeane directory
    1. Build the project
        1. Install Gradle
            
            `sudo apt update && sudo apt update -Y && sudo apt install gradle -Y`
        1. Build the project
            
            `gradle build`
    1. Run Springboot
    
        `java -jar build/libs/DanielKeane-live.war`