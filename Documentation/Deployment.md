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
    1. Update the application.properties file
        1. Go to the resources directory /app/DanielKeane/src/main/resources
        1. Rename application-example.properties --> application.properties
        1. Go to Spotify Developer Account for credentials (https://developer.spotify.com/dashboard)
        1. Fill in application.properties file with credentials
    1. Configure the port forwarding (8080 --> 80)
    
        `chmod +x networkSetup.sh`
        `sudo ./networkSetup.sh`
    
    1. Run Springboot
    
        `java -jar build/libs/DanielKeane-live.war`
        
    1. Check the URL/IP of the instance & play around

1. Run it as a service
    1. Create the service
    
        `sudo cp danielkeane.service /etc/systemd/system/danielkeane.service`
    1. Start the service
    
        `sudo systemctl daemon-reload`
        `sudo systemctl enable danielkeane.service`
        `sudo service danielkeane start`
        `sudo service danielkeane status`
        
    1. Logging
    
        `sudo journalctl -f -n 1000 -u danielkeane`
        
1. Point the domain to it
    1. Login to the lightsail dashboard
    1. Networking tab
    1. Click on the DanielKeane-sip
    1. Detach it from the old instance
    1. Attach it to the new instance