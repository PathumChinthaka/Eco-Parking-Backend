const { Eureka } = require('eureka-js-client');

const eureka = new Eureka({
  instance: {
    app: 'VEHICLE-SERVICE',
    instanceId: 'vehicle-service-instance-1',
    hostName: 'localhost',
    ipAddr: '127.0.0.1',
    port: {
      '$': 8090,
      '@enabled': true
    },
    vipAddress: 'vehicle-service',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn'
    },
    healthCheckUrl: 'http://localhost:8090/health',  
  },
  eureka: {
    host: 'localhost',
    port: 8761,
    servicePath: '/eureka/apps/',
    maxRetries: 5,
    requestRetryDelay: 5000
  }
});

// Start Eureka client
eureka.start(error => {
  if (error) {
    console.error('Eureka registration failed:', error);
  } else {
    console.info('Registered with Eureka');
  }
});
