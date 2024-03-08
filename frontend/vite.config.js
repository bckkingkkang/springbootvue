import { defineConfig } from 'vite'
import path from "path"
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig(() => {

  const configure = function(proxy, _options) {
    proxy.on("error", (err, _req, _res) => {
      console.log("proxy error", err);
    });
    proxy.on("proxyRes", (proxyRes, req, _res) => {
      const { protocol, host, port } = proxyRes.socket._httpMessage;
      console.log(
          "Received Response from the Target:",
          proxyRes.statusCode,
          `${protocol}//${host}${req.url}`
      );
    });
  }

  return  {
    plugins : [
      vue(),
    ],
    server : {
      port : 8082,
      proxy : {
        '/api/' : {
          target :'http://192.168.2.1',
          changeOrigin: true,
          configure,
          secure: false,
          ws: true
        }
      }
    },

    resolve : {
      alias : [
        { find : '@', replacement : path.resolve(__dirname, "src")},
        {
          find: "@components",
          replacement: path.resolve(__dirname, "src/components"),
        },
      ]
    }
  }
})
