import { defineConfig } from 'vite'
import path from "path"
import vue from '@vitejs/plugin-vue'

export default defineConfig(() => {

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
