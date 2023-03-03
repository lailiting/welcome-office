import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
// autoImport
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import  { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
// https://vitejs.dev/config/
export default defineConfig({
  server : {
    port : 3000,
    proxy : {
      "/api1" : {
        target : "http://47.100.198.142:8085",
        changeOrigin : true,
        rewrite :(path) => path.replace(/^\/api1/, '')
      },
      "/api2" : {
        target : "http://114.115.136.191:8085",
        changeOrigin : true,
        rewrite :(path) => path.replace(/^\/api2/, '')
      },
      "/api_zh" : {
        target : "http://47.100.198.142:8085",
        changeOrigin : true,
        rewrite :(path) => path.replace(/^\/api_zh/, '')
      },


    }
  },
  resolve:{
    alias:{
      '/assets':'/src/assets',
      'utils':'/src/utils'
    }
  },
  plugins: [
    vue(),
    AutoImport({
      imports:['vue'],
      dts:'src/auto-import.d.ts',
      resolvers:[ElementPlusResolver()]
    }),
    Components({
      resolvers:[ElementPlusResolver()]
    })
  ]
})
