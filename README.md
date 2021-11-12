# DockerSeleniumDemo

![alt text](https://miro.medium.com/max/489/1*_hcrzlatMmlm_HG30FIW9A.jpeg)

This Repository Contains Java code as client library and I have used Docker to setup Selenium Grid (version 4 and version 3 as well).
We have written code to launch scripts in both version of grid.Also we have included Docker-compose.yml files for each Grid version. You can find under /DockerComposeFiles folder.

Our Current setup is:

![alt text](https://testautomationconcepts.files.wordpress.com/2020/07/ds-e1594076703581.png)

Our code can handle all 3 primary browser UI automation (Chrome ,FIrefox and edge browser). All node are configured through Docker Compose file.

                     **For Selenium Grid 3**

If you need to increase the no of instances of browse also session then you have to write in compose file
**NODE_MAX_SESSION: 4**
**NODE_MAX_INSTANCES: 4**


                            **For Selenium Grid 4**
                            
  If you need to increase the no of instances of browse also session then you have to write in compose file
  **SE_NODE_MAX_INSTANCES=4
    SE_NODE_MAX_SESSIONS=4**
 
