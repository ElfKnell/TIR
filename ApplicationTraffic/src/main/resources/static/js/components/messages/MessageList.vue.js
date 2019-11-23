"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
-container >
    -form;
messageAttr = "message" /  >
    -row;
v - ;
for ( = "message in sortedMessages"; ; )
    : key = "message.id";
message = "message";
editMessage = "editMessage" /  >
    /v-container>
    < /template>
    < script >
;
var vuex_1 = require("vuex");
var MessageRow_vue_1 = require("components/messages/MessageRow.vue");
var MessageForm_vue_1 = require("components/messages/MessageForm.vue");
exports.default = {
    components: {
        MessageRow: MessageRow_vue_1.default,
        MessageForm: MessageForm_vue_1.default
    },
    data: function () {
        return {
            message: null
        };
    },
    computed: vuex_1.mapGetters(['sortedMessages']),
    methods: {
        editMessage: function (message) {
            this.message = message;
        }
    }
}
    < /script>
    < style > /style>;
