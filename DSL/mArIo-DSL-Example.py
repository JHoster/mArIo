class Player():
    title = "Super"
    name = "Mario"
    color = "Red"
    
    def __str__(self):
        return "Player=>" + "[" + self.title + " " + self.name + ", " + self.color + "]"

    def setTitle(self, aTitle):
        self.title = aTitle
        return self

    def setName(self, aName):
        self.name = aName
        return self

    def setColor(self, aColor):
        self.color = aColor
        return self

player = Player()
player.setTitle("Great").setName("Luigi").setColor("Green")
    
print("Print Players")
print(player)