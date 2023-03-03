import DogIcon from "./DogIcon/index.vue"
import ProjectIcon from "./ProjectIcon/index.vue"
import MemberIcon from "./MemberIcon/index.vue"
import StudyIcon from "./StudyIcon/index.vue"
import DailyIcon from "./DailyIcon/index.vue"
import ContactIcon from "./ContactIcon/index.vue"

let CustomIcon = {}

CustomIcon.install = function(Vue){
    Vue.component(DogIcon.name, DogIcon)
    Vue.component(ProjectIcon.name, ProjectIcon)
    Vue.component(MemberIcon.name, MemberIcon)
    Vue.component(StudyIcon.name, StudyIcon)
    Vue.component(DailyIcon.name, DailyIcon)
    Vue.component(ContactIcon.name, ContactIcon)
}

export default CustomIcon