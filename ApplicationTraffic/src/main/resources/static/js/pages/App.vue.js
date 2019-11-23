"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
-app >
    -app - bar;
color = "deep-purple accent-4";
dark >
    -app - bar - nav - icon > /v-app-bar-nav-icon>
    < v - toolbar - title > TIR < /v-toolbar-title>
    < div;
var default_1 = /** @class */ (function () {
    function default_1() {
    }
    return default_1;
}());
"flex-grow-1" > /div>
    < span;
v - ;
if ( = "profile" > {}) {
    profile.name;
}
/span>
    < v - btn;
v - ;
if ( = "profile")
    icon;
href = "/logout" >
    -icon > exit_to_app < /v-icon>
    < /v-btn>
    < /v-app-bar>
    < /div>
    < v - content >
    -container;
v - ;
if ( = "!profile" >
    You)
    need;
authorisation;
from < a;
href = "/login" > Google < /a>
    < /v-container>
    < v - container;
v - ;
if ( = "profile" >
    -list /  >
    /v-container>
    < /v-content>
    < /v-app>
    < /template>
    < script >
)
    import { mapState, mapMutations } from "vuex";
var MessageList_vue_1 = require("components/messages/MessageList.vue");
var ws_js_1 = require("util/ws.js");
exports.default = {
    components: {
        MessagesList: MessageList_vue_1.default
    },
    computed: vuex_1.mapState(['profile']),
    methods: vuex_1.mapMutations(['addMessageMutation', 'updateMessageMutation', 'removeMessageMutation']),
    created: function () {
        var _this = this;
        ws_js_1.addHandler(function (data) {
            if (data.objectType === 'MESSAGE') {
                //const index = this.messages.findIndex(item => item.id === data.body.id)
                switch (data.eventType) {
                    case 'CREATE':
                        _this.addMessageMutation(data.body);
                        break;
                    case 'UPDATE':
                        _this.updateMessageMutation(data.body);
                        break;
                    case 'REMOVE':
                        _this.removeMessageMutation(data.body);
                        break;
                    default:
                        console.error("Looks like the event type if unknown \"" + data.eventType + "\"");
                }
            }
            else {
                console.error("Looks like the object type if unknown \"" + data.objectType + "\"");
            }
        });
    }
}
    < /script>
    < style >
    /style>;
