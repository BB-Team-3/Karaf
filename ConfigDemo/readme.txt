paste this cfg file in karaf/etc folder

feature:repo-add mvn:com.motivity/c-feature/0.0.1-SNAPSHOT/xml

feature:install c-service-datasource

feature:install c-service-api

feature:install c-demo