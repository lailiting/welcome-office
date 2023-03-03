import $http from 'utils/services'
class server{
    menuData
    directionInfo
    cardInfo
    activeTabs=reactive({})
    constructor(){

    }

    async httpMenuData(){
        
    }

    async httpDirectionInfo(){
        const res = await $http.get('/direction/list') 

        //init activeTabs
        res.data.forEach(item=>{
            this.activeTabs[item.type] = item.way[0].id
        })
        this.directionInfo = res.data
        return res
    }

    async httpCardInfo(params){
        const res = await $http.get('/studyData/list',params)
        return res
    }

    updateActiveTabById(idStr){
        // return
        const [d_id,w_id ] =  idStr.split('-')
        let d_info = this.directionInfo.find(item=>{
            return item.id == d_id
        })
        let newTabId = d_info.way.find(item=>{
            return item.id == w_id
        })
        this.activeTabs[d_info.type] = newTabId.id
    }
}
// const defaultTab = reactive({})
// menuData.forEach(item=>{
//     defaultTab[item.routeID] = item.children[0].id
// })

// export const activeTabs = reactive({...defaultTab})

export default new server()


export const menuData = [
    {
        title:"前端",
        routeID:'front-end',
        children:[
            {
                title:'音乐',
                routeID:'front-end-music',
                sources:[
                    {
                        cover:'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png',
                        target:'',
                        content:'好吃的汉堡，亚弥亚密',
                    }
                ]
            },
            {
                title:"视频",
                routeID:'front-end-video',
                sources:[
                    {
                        cover:'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png',
                        target:'',
                        content:'看起来还是汉堡，实际是视频了',
                    }
                ]
            },
            {
                title:'小说',
                routeID:'front-end-article'
            }
        ]
    },
    {
        title:'后端',
        routeID:'backend',
        children:[
            {
                title:'音乐',
                routeID:'backend-music'
            }
        ]
    },
    {
        title:'UI',
        routeID:'ui',
        children:[
            {
                title:'音乐',
                routeID:'UI-music'
            }
        ]
    }
]


// console.log(activeTabs['front-end'])