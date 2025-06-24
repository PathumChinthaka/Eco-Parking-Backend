const axios = require('axios');

async function fetchConfig() {
  try {
    const res = await axios.get('http://localhost:8888/vehicle-service/default');
    const config = res.data.propertySources.reduce((acc, source) => {
      return { ...acc, ...source.source };
    }, {});
    return config;
  } catch (err) {
    console.error('Failed to fetch config', err);
    process.exit(1);
  }
}

module.exports = {fetchConfig}
