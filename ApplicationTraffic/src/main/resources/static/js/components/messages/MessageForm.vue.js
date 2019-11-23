"use strict";
var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
Object.defineProperty(exports, "__esModule", { value: true });
-row >
    -col;
cols = "12";
sm = "6";
md = "3" >
    -text - field;
label = "Write something";
outlined;
v - model;
"text" >
    /v-text-field>
    < /v-col>
    < v - col;
cols = "12";
sm = "6" >
    -btn;
outlined;
height = "56px";
x - large;
color = "indigo";
"save" >
    Save
    < /v-btn>
    < /v-col>
    < /v-row>
    < /template>
    < script >
;
var vuex_1 = require("vuex");
exports.default = {
    props: ['messageAttr'],
    data: function () {
        return {
            text: '',
            id: ''
        };
    },
    watch: {
        messageAttr: function (newVal, oldVal) {
            this.text = newVal.text;
            this.id = newVal.id;
        }
    },
    methods: __assign({}, vuex_1.mapActions(['addMessageAction', 'updateMessageAction']), { save: function () {
            var message = { id: this.id, text: this.text };
            if (this.id) {
                this.updateMessageAction(message);
            }
            else {
                this.addMessageAction(message);
            }
            this.text = '',
                this.id = '';
        } })
}
    < /script>
    < style >
    /style>;
