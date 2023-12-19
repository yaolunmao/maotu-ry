import autoImport from 'unplugin-auto-import/vite'

export default function createAutoImport() {
    return autoImport({
        imports: [
            'vue',
            'vue-router',
            'pinia'
        ],
        exclude: [/node_modules/,/vue-webtopo-svgeditor/,/lib/,/maotu/],
        dts: false
    })
}
