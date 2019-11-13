var budgetController = function(){
    var Incomes = function(id, description, value){
        this.id = id;
        this.description = description;
        this.value = value;
    };

    var Expenses = function(id, description, value){
        this.id = id;
        this.description = description;
        this.value = value;
        this.percentage = -1;
    };

    Expenses.prototype.calcPer = function(totalIncome){
        if (totalIncome > 0){
            this.percentage = Math.round((this.value / totalIncome)*100);
        }
        else {
            this.percentage = -1;
        }
        
    };

    Expenses.prototype.getPercentage = function(){
        return this.percentage;
    }    

    var calculateTotal = function(type){
        var sum = 0;
        data.allItems[type].forEach(function(currt){
            sum += currt.value;
        });
        
        data.totals[type] = sum;   
    };
    var data = 
    {
        allItems: {
            exp: [],
            inc: []
        },

        totals:{
            exp:0,
            inc:0
        },

        budget: 0,
        percentage: -1
    };

    return{
        addItem: function(type,des,val){
            var newItem, id;           
            //[1 2 3 4 5] next ID = 6
            //[1 2 4 6 8] next ID = 9
            //ID = last ID + 1

            //Create new ID
            if (data.allItems[type].length > 0){
            //      //it started from nothing, then the first id is 0
            //     //which is assigned below
                var pos = data.allItems[type].length - 1;
                
                id = data.allItems[type][pos].id + 1 ;
                     
            }else {
                id = 0;
            }
            
            if (type === "inc"){
                newItem = new Incomes(id,des,val);  
            }

            else if (type === "exp"){
                newItem = new Expenses(id,des,val);
            }

            data.allItems[type].push(newItem);
            return newItem;
        },

        deleteItem: function(type, id){
          //id=6
          //ids = [1 2 4 6 8]
          //index = 3
          
            var ids =  data.allItems[type].map(function(current){
                return current.id;
            }); //create new array ids includes all id
             
            var index = ids.indexOf(id);

            if(index !== -1){
                data.allItems[type].splice(index,1);
            }
        },

        calculateBudget: function(){
            //Calculate total income and expenses
            calculateTotal('exp');
            calculateTotal('inc');

            //Calcualte the budget: income - expenses
            data.budget = (data.totals.inc - data.totals.exp) ;

            //Ca;culate the % of income 
            if (data.totals.inc > 0){
                data.percentage = Math.round((data.totals.exp / data.totals.inc)*100);
            }
            else {
                data.percentage = -1;
            }
        },

        getBudget: function(){
            return {
                budget: data.budget,
                totalInc: data.totals.inc,
                totalExp: data.totals.exp,
                percentage: data.percentage
            }
        },

        calculatePer: function(){
            data.allItems.exp.forEach(function(current){
                current.calcPer(data.totals.inc);
            });           
        },

        getPer: function(){
            var allPerc = data.allItems.exp.map(function(cur){ //Create a new array with all percentage data
                return cur.getPercentage();
            }) ;
            //console.log(allPerc);
            return allPerc; //return new array with all percentages
            
        },

        testing: function(){
            console.log(data.allItems);
        }
    }
}();

var UIController = function(){
    var DOMstrings = {
        inputType: '.add__type',
        inputDescription: ".add__description",
        inputValue: ".add__value",
        inputButton: ".add__btn",
        incomeContainer: ".income__list",
        expenseContainer: ".expenses__list",
        budgetLabel: '.budget__value',
        incomeLabel: '.budget__income--value',
        expenseLabel: '.budget__expenses--value',
        percentageLabel: '.budget__expenses--percentage',
        container: ".container",
        expensesPercLabel: ".item__percentage"
    };

    var formatNumber = function(num, type){
        /*
        + or - before number exactly 2 decimal points
        comma separating the thousands 
        2310.4567 -> +2,310.46
        2310 -> +2,000.00
        */
        var split, int, dec;
        num = Math.abs(num);
        num = num.toFixed(2); // Convert a number into a string, keeping only two decimals
        split = num.split(".");
        int = split[0]; 
        if (int.length > 3){
            int = int.substr(0,int.length - 3) + ',' + int.substr(int.length - 3, 3); //input 12345 -> 12 + , + 
        }
        dec = split[1];
        return (type === "exp" ?  "-" : "+") + " $" + int + "." + dec;
        //if type is exp then sign is - else sign is +
    };

    return{
        getInput: function(){
            return {
                type : document.querySelector(DOMstrings.inputType).value,
                description : document.querySelector(DOMstrings.inputDescription).value,
                value : parseFloat(document.querySelector(DOMstrings.inputValue).value)
            }
        },

        

        getDOMStrings: function(){
            return DOMstrings;
        },

        displayPercentage: function(percent){
            var fields = document.querySelectorAll(DOMstrings.expensesPercLabel);
            
            //Declare function
            var nodeListForEach = function(list, callback){
                for (var i = 0; i < list.length; i++){
                    callback(list[i],i);
                }
            };

            //Run function
            nodeListForEach(fields, function(current, index){
                if(percent[index] > 0){
                    current.textContent = percent[index] + '%';
                }
                else {
                    current.textContent = "--";
                }
                
            });
        },

        displayBudget: function(obj){
            var type;
            obj.budget > 0 ? type = "inc" : type = "exp";
            document.querySelector(DOMstrings.budgetLabel).textContent =  formatNumber(obj.budget, type);
            document.querySelector(DOMstrings.incomeLabel).textContent =  formatNumber(obj.totalInc,"inc");
            document.querySelector(DOMstrings.expenseLabel).textContent =  formatNumber(obj.totalExp, "exp");
            //document.querySelector(DOMstrings.percentageLabel).textContent = obj.percentage;

            if(obj.percentage > 0){
                document.querySelector(DOMstrings.percentageLabel).textContent = obj.percentage + "%";
            }
            else {
                document.querySelector(DOMstrings.percentageLabel).textContent ="---";
            }
        },

        addListItem: function(obj,type){
            var html, newHtml, element;
            //Create HTML string with placeholder text
            if (type === "inc"){
                element = DOMstrings.incomeContainer;
                html = '<div class="item clearfix" id="inc-%id"><div class="item__description">%description%</div><div class="right clearfix"><div class="item__value">%value%</div><div class="item__delete"><button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button></div></div></div>';
            }
            else if (type === "exp"){
                element = DOMstrings.expenseContainer;
                html = '<div class="item clearfix" id="exp-%id"><div class="item__description">%description%</div><div class="right clearfix"><div class="item__value">%value%</div><div class="item__percentage">%percentage%</div><div class="item__delete"><button class="item__delete--btn"><i class="ion-ios-close-outline"></i></button></div></div></div>';
            }

            //Replace the placeholder text with actual data
            newHtml = html.replace('%id',obj.id);
            newHtml = newHtml.replace('%description%',obj.description);
            newHtml = newHtml.replace('%value%',formatNumber(obj.value,type));
            

            //Insert the HTML into DOM
            document.querySelector(element).insertAdjacentHTML('beforeend',newHtml);
        },

        deletelistItem: function(selectID){
            var el = document.getElementById(selectID);
            el.parentNode.removeChild(el);
        },

        clearFields: function(){
            var fields, fieldsArray;
            fields = document.querySelectorAll(DOMstrings.inputDescription + ',' + DOMstrings.inputValue);
            fieldsArray = Array.prototype.slice.call(fields);

            fieldsArray.forEach(function(current,index,array){
                current.value = "";
            }
            );
        }
    }
}();

var controller = function(budgetCtrl,UICtrl){
    
    var setupEventListeners = function(){
        var DOM = UICtrl.getDOMStrings();
        document.querySelector(DOM.inputButton).addEventListener("click",ctrlAddItem);

        document.addEventListener("keypress", function(event){
            if (event.keyCode === 13 || event.which === 13){
                ctrlAddItem();
            }
        });

        document.querySelector(DOM.container).addEventListener("click", ctrlDeleteItem);
    };
    
    var updateBudget = function(){
        var budget;
        //1. Calculate the budget
        budgetCtrl.calculateBudget();

        //2. Return the budget
        budget = budgetCtrl.getBudget();

        //3. Display the budget on the UI
        UICtrl.displayBudget(budget);
    };

    var updatePer = function(){
        //1. Calculate percentage
        budgetCtrl.calculatePer();

        //2. Read the % from the budget controller
        var percentages = budgetCtrl.getPer();

        //3. Update the UI with new %
        UICtrl.displayPercentage(percentages);
    };

    var ctrlAddItem = function(){
        var input, newItem;
        //1. Get the input field
        input = UICtrl.getInput();
        //console.log(input);
        if (input.description !== "" && !isNaN(input.value) && input.value > 0 ){
            //2. Add the item to the budget controller
            newItem = budgetCtrl.addItem(input.type,input.description,input.value);
            console.log(newItem);

            //console.log(newItem)   ;     
        
            //3. Add the item to the UI
            UICtrl.addListItem(newItem,input.type);
        
            //4. Clear fields
            UICtrl.clearFields();
        
            //5. Calculate and update budget
            updateBudget();

            //6. Calculate and update %
            updatePer();
        }
    };

    var ctrlDeleteItem = function(event){
        var itemID, splitID, type, id;

        itemID = (event.target.parentNode.parentNode.parentNode.parentNode.id);

        if (itemID){
            //inc-1
            splitID = itemID.split('-'); //array splitID
            type = splitID[0];
            id = parseInt(splitID[1]); //after splice it becomes a string, 
            //must convert to integer to use in the method

            //1. Delete the item from the data structure
            budgetCtrl.deleteItem(type, id);

            //2. Delete the item from the UI
            UICtrl.deletelistItem(itemID);

            //3. Update and show the new data
            updateBudget();

            //4. Calculate and update %
            updatePer();
        }


    };

    return {
        init: function(){
            console.log("Application has started.");
            setupEventListeners();
            UICtrl.displayBudget({
                budget: 0,
                totalInc: 0,
                totalExp: 0,
                percentage: -1
            });
        }
    };
}(budgetController,UIController);

controller.init();
