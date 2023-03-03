import $http from 'utils/services'

class server{
    constructor(){

    }

    view(){
        return $http.get('/contact/view')
    }
}


export default new server()