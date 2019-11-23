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
-card;
var default_1 = /** @class */ (function () {
    function default_1() {
    }
    return default_1;
}());
"my-2" >
    -card - title;
var default_2 = /** @class */ (function () {
    function default_2() {
    }
    return default_2;
}());
"align-end fill-height" >
    ({});
{
    message.id;
}
/i> &ensp; {{ message.text }}
    < /v-card-title>
    < v - card - actions >
    -btn;
text;
outlined;
color = "purple";
"edit" >
    Edit
    < /v-btn>
    < v - btn;
icon;
"del" >
    -icon > delete /v-icon>
    < /v-btn>
    < /v-card-actions>
    < /v-card>
    < /template>
    < script >
;
var vuex_1 = require("vuex");
exports.default = {
    props: ['message', 'editMessage'],
    methods: __assign({}, vuex_1.mapActions(['removeMessageAction']), { edit: function () {
            this.editMessage(this.message);
        },
        del: function () {
            this.removeMessageAction(this.message);
        } })
}
    < /script>
    < style >
    /style>;
