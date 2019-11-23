
import Vue from 'vue'

const mesages = Vue.resource('/message{/id}')

export default {
    add: mesage => mesages.save({}, mesage),
    update: mesage => mesages.update({id: mesage.id}, mesage),
    remove: id => mesages.remove({id})
}