(function($){

    function generateID(viewManager, nodeName){
        return viewManager.getFunctionalityName()+"_"+nodeName;
    }

    function NodeManager(nodeName, extensionClass){
        var _o = this;
        var _nodeName = nodeName;

        _o.getFunctionalityName = function getFunctionalityName(){
            return _nodeName;
        }

        var t = new extensionClass(_o,arguments);

        Object.keys(t,function(s){

        })


    };

    var LoginNodeManager = new NodeManager("login",function LoginNodeManager(super){
        var _super = super;
        var _o = this;

        var loginFormID = "form";
        var loginPanelID = "panel";

        var loginFormElement = $("#"+loginFormID);
        var loginPanelElement = $("#"+loginPanelID);


    }


})(jQuery);