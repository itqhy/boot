// const url = 'http://192.168.185.56:9999'
const url = 'http://127.0.0.1:8081'
module.exports = {
  lintOnSave: true,
  productionSourceMap: false,
  publicPath: '/boot/',
  chainWebpack: config => {
    // 忽略的打包文件
    config.externals({
      'axios': 'axios',
    })
    const entry = config.entry('app')
    entry
      .add('babel-polyfill')
      .end()
    entry
      .add('classlist-polyfill')
      .end()
  },
  // 配置转发代理
  devServer: {
    proxy: {
      '/quartz': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/quartz': '/quartz'
        }
      },
      '/auth': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/auth': '/auth'
        }
      },
      '/admin': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/admin': '/admin'
        }
      },
      '/code': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/code': '/code'
        }
      },
      '/gen': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/gen': '/gen'
        }
      },
      '/daemon': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/daemon': '/daemon'
        }
      },
      '/tx': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/tx': '/tx'
        }
      },
      '/act': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/act': '/act'
        }
      },
      '/pay': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/pay': '/pay'
        }
      },

      '/pan': {
        target: url,
        ws: true,
        pathRewrite: {
          '^/pan': '/pan'
        }
      }
    }
  }
}
