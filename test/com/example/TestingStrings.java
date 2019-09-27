package com.example;

public class TestingStrings {

    static String URL_STRING = "{\n" +
            "  \"startingRoom\": \"TheWoods\",\n" +
            "  \"endingRoom\": \"TheCity\",\n" +
            "  \"hungerStatus\": [\n" +
            "    \"Your stomach rumbles. It had been days since you had last eaten. Looking across the landscape, game and fruit seemed to be sparse, and water was out of sight. \\nThough currently willpower might be enough to hold yourself together, you question how long you might last.\",\n" +
            "    \"With each step, your arms and legs seem heavier, your midsection aching as you push yourself forward. \\nThough the thoughts of survival keep the hunger at bay, it gnaws on your will with a persistence that could not be ignored.\",\n" +
            "    \"As you step forward, you knees buckle underneath you, your strength failing to keep you up as hunger and thirst claw at your mind. \\nYou find your vision slowly growing dark as your body tries to conserve what little energy it has left. As the world fades away, you wonder what else you could have done.\"\n" +
            "  ],\n" +
            "  \"player\": {\n" +
            "    \"items\": []\n" +
            "  },\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"TheWoods\",\n" +
            "      \"description\": \"As you step forward, the sunlight washing over you in a deep golden wave, a forest stands in front of you. \\nThe dense woodland forms a natural wall from which you wondered how you managed to find your way out of. \\nLooking back, the shadows seem to grow with each passing moment, looming closer and closer as the darkness aims to swallow up the world for another night. Shuddering, you place the wooded barrier to your back and turn to look forward. \\n You see a natural path cut into the grass before you, diverging just a little ways ahead.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"directionDescription\": \"Looking towards the east, you see the dirt and grass turn to pebbles and sand. \\nThe smell of the sea washes over you, as do the faint sounds of water. It doesn't seem to be too far off.\",\n" +
            "          \"room\": \"BeachPath\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"North\",\n" +
            "          \"directionDescription\": \"As your gaze falls to the North, you see a more defined path, the grass cleared away with intention. \\nPerhaps another being had managed to come here before you? Something faint appears on the horizon over the gentle slope of a small hill.\",\n" +
            "          \"room\": \"ForestCabin\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"directionDescription\": \"Looking at the middle of the three paths, you see that it cuts through the rolling landscape. \\nWinding between the various small hills, it leads towards a growing set of what could either be defined as a small mountain or a large hill.\",\n" +
            "          \"room\": \"Foothill\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Debug\",\n" +
            "          \"directionDescription\": \"\",\n" +
            "          \"room\": \"Debug\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"hidden\": true,\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"BeachPath\",\n" +
            "      \"description\": \"Your feet begin to sink into the ground with each step as the dirt turns to sand. \\nThough not unusual terrain, the extra effort to walk on the sandy surface of the beach seems to sap at your strength just a little bit more than the hard ground before. You're faced with the ocean in front of you, the gentle lapping of the waves against the beachhead filling the air with a calming white noise. \\nSomething glints in the sand at your feet.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"directionDescription\": \"Looking back from where you came, you can see the forest in the distance, the small trail that your shoes had left in the sand visible against the golden sun. \",\n" +
            "          \"room\": \"TheWoods\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"directionDescription\": \"Looking ahead, you see a small shack in the distance. It appears small against the rolling yellow white sand dunes, but prominent. It doesn't seem too far away, perhaps you should check out what's there?\",\n" +
            "          \"room\": \"BeachShack\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemName\": \"shinyObject\",\n" +
            "          \"inventoryName\": \"Key\",\n" +
            "          \"toBePrinted\": false,\n" +
            "          \"edible\": false,\n" +
            "          \"description\": \"The shine in the sand catches your eyes. \\nYou crouch down to pick it up. As your hand brushes against the surface, you feel the metal shape of what appears to be a key! The sand falls away revealing a rusted key, scarred by the salty air and the water.\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"BeachShack\",\n" +
            "      \"description\": \"With each step, your muscles began to cramp as you approach the wooden shack. The sand was not kind to your weary body. Taking a breath, your eyes begin to take in the scene.\\n A deep blue ocean sat under a pink sky, the golden orb of the sun hanging low in the air as it worked its way down the sky. Sand was piled up against the shack, the windows cracked and the color of the wood faded with time. \\nWalking up front, the door seemed to be left open, a dusty, dirty home with nothing of value was revealed.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"directionDescription\": \"With malice, you look back at where you came from, the forest now blurred by the fog of distance. Your legs cramp up as you think about the walk you would have to take to go back to that dirty path.\",\n" +
            "          \"room\": \"BeachPath\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"ForestCabin\",\n" +
            "      \"description\": \"As you step over the hill, a house reveals itself to you. A nice dark wood frames the home, a picturesque hut with the sun shining on the felled timber. The area around it had the marks of being maintained but since overgrown. As you approach the cabin, you see pieces of felled lumber stacked up beside it and spent coals in a pit beside a spit roast. Standing in front of it presents you with a door, a thick metal padlock worn and rusted by the passage of time denying you entry to what might be inside.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Inside\",\n" +
            "          \"directionDescription\": \"Looking through the window of the cabin, you can vaguely make out some basic shapes. The glass isn't very conducive to peeping.\",\n" +
            "          \"room\": \"FoodRoom\",\n" +
            "          \"enabled\": \"false\",\n" +
            "          \"validKeyNames\": [\n" +
            "            \"shinyObject\"\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"directionDescription\": \"Looking behind you, you see the forest curve off and the water faintly twinkle on the horizon. The faint rays of light of the quickly ending day highlight a scene that would be enjoyable to just sit and watch had you not been on the brink of starvation.\",\n" +
            "          \"room\": \"TheWoods\",\n" +
            "          \"enabled\":\"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"FoodRoom\",\n" +
            "      \"description\": \"Entering the cabin presents you with an interior devoid of much of anything. A worn axe laid off to the side, chipped and broken. \\nIt seemed to be abandoned for all you could tell. Looking at the table, you're presented with a worn photo of a family with faded faces. Suddenly, the sharp smell of meat hits your nose. Turning back, behind the door, you see a cooked slab of meat. It seems tantalizing, the aroma overpowering.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Outside\",\n" +
            "          \"directionDescription\": \"It's outside. You look out the door to see where you just came in from. Nothing new, other than the sun slightly lower than where it was, the gold rays dimming as time marched forward.\",\n" +
            "          \"room\": \"ForestCabin\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\":[]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemName\": \"sliceOfMeat\",\n" +
            "          \"inventoryName\": \"Meat\",\n" +
            "          \"toBePrinted\": true,\n" +
            "          \"edible\": true,\n" +
            "          \"description\": \"As you look at the meat, your hunger seems to command your movements as you hungrily devour it. Not caring much for etiquette or hygiene, it disappears in chunks as you tear off bit by bit and refuel your malnourished body.\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Foothill\",\n" +
            "      \"description\": \"Foothill_DESC\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Southwest\",\n" +
            "          \"directionDescription\": \"BackToForest\",\n" +
            "          \"room\": \"TheWoods\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"directionDescription\": \"Into the mountains\",\n" +
            "          \"room\": \"MountainPass\",\n" +
            "          \"enabled:\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"MountainPass\",\n" +
            "      \"description\": \"MountainDesc\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Left\",\n" +
            "          \"directionDescription\": \"ripuded\",\n" +
            "          \"room\": \"TheFall\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Right\",\n" +
            "          \"directionDescription\":\"towards safety\",\n" +
            "          \"room\": \"PathToCity\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"TheFall\",\n" +
            "      \"description\": \"OhNoYouSlipped\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Left\",\n" +
            "          \"directionDescription\": \"ripuded\",\n" +
            "          \"room\": \"Death\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Right\",\n" +
            "          \"directionDescription\":\"brokenLegsButokay\",\n" +
            "          \"room\": \"PathToCity\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Death\",\n" +
            "      \"description\": \"RIPINPIECES\",\n" +
            "      \"directions\": [],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"PathToCity\",\n" +
            "      \"description\": \"CityAhead\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Southwest\",\n" +
            "          \"directionDescription\": \"Why would you go back to the mountains\",\n" +
            "          \"room\": \"MountainPass\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"directionDescription\":\"ay look its the city\",\n" +
            "          \"room\": \"TheCity\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"TheCity\",\n" +
            "      \"description\": \"YouMadeIt!\",\n" +
            "      \"directions\": [],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Debug\",\n" +
            "      \"description\": \"DebugMenu\",\n" +
            "      \"directions\": [],\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemName\": \"Teleporter\",\n" +
            "          \"inventoryName\": \"debugTeleporter\",\n" +
            "          \"toBePrinted\": true,\n" +
            "          \"edible\": false,\n" +
            "          \"description\": \"As you look at the item before you, it glows pink and black. You know it's not supposed to exist, yet somehow it seems right as it magnetically sticks to your hand. Congrats, you're now in debug mode. .\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    static String MY_ADVENTURE_JSON = "{\n" +
            "  \"startingRoom\": \"TheWoods\",\n" +
            "  \"endingRoom\": \"TheCity\",\n" +
            "  \"hungerStatus\": [\n" +
            "    \"Your stomach rumbles. It had been days since you had last eaten. Looking across the landscape, game and fruit seemed to be sparse, and water was out of sight.\\nThough currently willpower might be enough to hold yourself together, you question how long you might last.\",\n" +
            "    \"With each step, your arms and legs seem heavier, your midsection aching as you push yourself forward.\\nThough the thoughts of survival keep the hunger at bay, it gnaws on your will with a persistence that could not be ignored.\",\n" +
            "    \"As you step forward, you knees buckle underneath you, your strength failing to keep you up as hunger and thirst claw at your mind.\\nYou find your vision slowly growing dark as your body tries to conserve what little energy it has left. As the world fades away, you wonder what else you could have done.\"\n" +
            "  ],\n" +
            "  \"player\": {\n" +
            "    \"items\": []\n" +
            "  },\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"TheWoods\",\n" +
            "      \"description\": \"As you step forward, the sunlight washing over you in a deep golden wave, a forest stands in front of you.\\nThe dense woodland forms a natural wall from which you wondered how you managed to find your way out of.\\nLooking back, the shadows seem to grow with each passing moment, looming closer and closer as the darkness aims to swallow up the world for another night.\\nShuddering, you place the wooded barrier to your back and turn to look forward.\\nYou see a natural path cut into the grass before you, diverging just a little ways ahead.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"directionDescription\": \"Looking towards the east, you see the dirt and grass turn to pebbles and sand.\\nThe smell of the sea washes over you, as do the faint sounds of water. It doesn't seem to be too far off.\",\n" +
            "          \"room\": \"BeachPath\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"North\",\n" +
            "          \"directionDescription\": \"As your gaze falls to the North, you see a more defined path, the grass cleared away with intention.\\nPerhaps another being had managed to come here before you? Something faint appears on the horizon over the gentle slope of a small hill.\",\n" +
            "          \"room\": \"ForestCabin\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"directionDescription\": \"Looking at the middle of the three paths, you see that it cuts through the rolling landscape.\\nWinding between the various small hills, it leads towards a growing set of what could either be defined as a small mountain or a large hill.\",\n" +
            "          \"room\": \"Foothill\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Debug\",\n" +
            "          \"directionDescription\": \"\",\n" +
            "          \"room\": \"Debug\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"hidden\": true,\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"BeachPath\",\n" +
            "      \"description\": \"Your feet begin to sink into the ground with each step as the dirt turns to sand.\\nThough not unusual terrain, the extra effort to walk on the sandy surface of the beach seems to sap at your strength just a little bit more than the hard ground before. You're faced with the ocean in front of you, the gentle lapping of the waves against the beachhead filling the air with a calming white noise. \\nSomething glints in the sand at your feet.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"directionDescription\": \"Looking back from where you came, you can see the forest in the distance, the small trail that your shoes had left in the sand visible against the golden sun. \",\n" +
            "          \"room\": \"TheWoods\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"directionDescription\": \"Looking ahead, you see a small shack in the distance. It appears small against the rolling yellow white sand dunes, but prominent. It doesn't seem too far away, perhaps you should check out what's there?\",\n" +
            "          \"room\": \"BeachShack\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemName\": \"Shiny Object\",\n" +
            "          \"inventoryName\": \"Key\",\n" +
            "          \"toBePrinted\": false,\n" +
            "          \"edible\": false,\n" +
            "          \"description\": \"The shine in the sand catches your eyes.\\nYou crouch down to pick it up. As your hand brushes against the surface, you feel the metal shape of what appears to be a key! The sand falls away revealing a rusted key, scarred by the salty air and the water.\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"BeachShack\",\n" +
            "      \"description\": \"With each step, your muscles began to cramp as you approach the wooden shack. The sand was not kind to your weary body. Taking a breath, your eyes begin to take in the scene.\\n A deep blue ocean sat under a pink sky, the golden orb of the sun hanging low in the air as it worked its way down the sky. Sand was piled up against the shack, the windows cracked and the color of the wood faded with time. \\nWalking up front, the door seemed to be left open, a dusty, dirty home with nothing of value was revealed.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"directionDescription\": \"With malice, you look back at where you came from, the forest now blurred by the fog of distance. Your legs cramp up as you think about the walk you would have to take to go back to that dirty path.\",\n" +
            "          \"room\": \"BeachPath\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"ForestCabin\",\n" +
            "      \"description\": \"As you step over the hill, a house reveals itself to you. A nice dark wood frames the home, a picturesque hut with the sun shining on the felled timber. The area around it had the marks of being maintained but since overgrown. As you approach the cabin, you see pieces of felled lumber stacked up beside it and spent coals in a pit beside a spit roast. Standing in front of it presents you with a door, a thick metal padlock worn and rusted by the passage of time denying you entry to what might be inside.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Cabin\",\n" +
            "          \"directionDescription\": \"Looking through the window of the cabin, you can vaguely make out some basic shapes. The glass isn't very conducive to peeping.\",\n" +
            "          \"room\": \"FoodRoom\",\n" +
            "          \"enabled\": \"false\",\n" +
            "          \"validKeyNames\": [\n" +
            "            \"shiny object\"\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"South\",\n" +
            "          \"directionDescription\": \"Looking behind you, you see the forest curve off and the water faintly twinkle on the horizon. The faint rays of light of the quickly ending day highlight a scene that would be enjoyable to just sit and watch had you not been on the brink of starvation.\",\n" +
            "          \"room\": \"TheWoods\",\n" +
            "          \"enabled\":\"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"FoodRoom\",\n" +
            "      \"description\": \"Entering the cabin presents you with an interior devoid of much of anything. A worn axe laid off to the side, chipped and broken.\\nIt seemed to be abandoned for all you could tell. Looking at the table, you're presented with a worn photo of a family with faded faces. Suddenly, the sharp smell of meat hits your nose. Turning back, behind the door, you see a cooked slab of meat. It seems tantalizing, the aroma overpowering.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Outside\",\n" +
            "          \"directionDescription\": \"It's outside. You look out the door to see where you just came in from. Nothing new, other than the sun slightly lower than where it was, the gold rays dimming as time marched forward.\",\n" +
            "          \"room\": \"ForestCabin\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\":[]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemName\": \"Meat\",\n" +
            "          \"inventoryName\": \"Slice of meat\",\n" +
            "          \"toBePrinted\": true,\n" +
            "          \"edible\": true,\n" +
            "          \"eatingInformation\": \"As you look at the meat, your hunger seems to command your movements as you hungrily devour it.\\nNot caring much for etiquette or hygiene, it disappears in chunks as you tear off bit by bit and refuel your malnourished body.\",\n" +
            "          \"description\": \"Picking up the slice of meat, you can feel it was still warm.\\nYour hands slightly dirty the item, but it still remained good to eat as you stow away the slice of meat inside your bag.\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Foothill\",\n" +
            "      \"description\": \"Walking in between the rolling hills, you find your legs growing tired with each step. The sun hangs low in the sky, shining golden rays on your face as you step forward.\\nAs the path grows steeper, you find yourself on the base of a small summit, looking up at a rocky hill. The pink sky casts long shadows behind you, the true task of what lies ahead hitting you with another wave of exhaustion. \",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Southwest\",\n" +
            "          \"directionDescription\": \"Looking back from where you came, you see the gradual increases in elevation had lead to a rather nice view of the land below.\\nThough not too high up, you can see over the tops of the trees, and a rolling sky overhead tinged with purple.\",\n" +
            "          \"room\": \"TheWoods\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"directionDescription\": \"Looking ahead, the true scale of the mountains finally hits. you. Your legs threaten to give way as your weary eyes scale up what would lay ahead if you were to continue down this path.\\nYou wonder if you're even up for it, as week as you are right now. Well, no time like the present to test out your limits!\",\n" +
            "          \"room\": \"MountainPass\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"MountainPass\",\n" +
            "      \"description\": \"The dirt and gravel under your feet turn to hard rock as your paining feet find purchase among the various stones.\\nVery methodically, you slowly climb up the mountain, moving each limb one at a time with a sort of deliberate action. Not only did this let you recuperate after each bit, but also made sure your footing stayed true. \",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Left\",\n" +
            "          \"directionDescription\": \"Looking left, you see a path over the peak of the cliff face,\\nIt disappears behind a set of large rocks that you can't look past, pick highlighting the sparking minerals embedded within. \",\n" +
            "          \"room\": \"TheFall\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Right\",\n" +
            "          \"directionDescription\":\"The right hosts a path much more sketchy than the left.\\nThough still defined, more loose rocks were scattered about, and it seemed to follow the edge of the little mountain before dipping over to the other side. \",\n" +
            "          \"room\": \"PathToCity\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"TheFall\",\n" +
            "      \"description\": \"As you climb up the left side of the mountain, you find yourself at the top. Looking down at your hands, red, but not bloodied, you wonder how you managed to make it.\\nTaking a deep breath, you prepare yourself to work back down the face of the mountain. As you step down, you find that the rock under your foot gives way! You tumble downwards, hiting your back and your legs.\\nDo you try to go towards the left or right?\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Left\",\n" +
            "          \"directionDescription\": \"You're going too fast, you can't tell what's ahead! What are you going to do?\",\n" +
            "          \"room\": \"Death\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Right\",\n" +
            "          \"directionDescription\":\"You're going too fast, you can't tell what's ahead! What are you going to do?\",\n" +
            "          \"room\": \"PathToCity\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Death\",\n" +
            "      \"description\": \"As you try to curl yourself up and shift your weight to the left, you feel a snaking branch crack against your back, forcing you open.\\nA rock hits your head, and you fall limp to the ground as your livelihood is drained fromn your body. Weak from hunger, you could do nothing but lay there as your senses slowly leave you, darkness washing over the landscape as you draw your final breath.\",\n" +
            "      \"directions\": [],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"PathToCity\",\n" +
            "      \"description\": \"As you work your way down the mountain, the brunt of what could have happened passed.\\nYou feel your leg, paining but manageable as you hobble along towards a dark silhouette in the foreground. With each step, you find renewed energy knowing that civilization was near, and that your ordeal was soon to end. With slow deliberate steps, you walk down the path towards the city.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"Southwest\",\n" +
            "          \"directionDescription\": \"You look back towards the mountain. It looms over you, the sun illuminating the face as you wonder how you managed to even overcome it. Shaking your head, you think it best to move on and not go back.\",\n" +
            "          \"room\": \"MountainPass\",\n" +
            "          \"enabled\": \"false\",\n" +
            "          \"validKeyNames\": []\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Northeast\",\n" +
            "          \"directionDescription\":\"The city lays ahead, still lit in the last hours of daylight. You figure you should go as fast as possible to tend to any sort of injuries you may have on your person.\",\n" +
            "          \"room\": \"TheCity\",\n" +
            "          \"enabled\": \"true\",\n" +
            "          \"validKeyNames\": []\n" +
            "        }\n" +
            "      ],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"TheCity\",\n" +
            "      \"description\": \"You find yourself entering the city just as the first street lamps were flickering on. With the sun now firmly below the horizon, you see the purple of night overtake the sky rapidly.\\nGasping a sigh of relief, the shadows of buildings, and the flickering of fires indoors all provide a sense of security as you see people once more, bustling around you.\\nThe scents and sounds of civilization were overwhelming as you hobble down the cobblestone streets, but reassuring.\\nYou're home.\",\n" +
            "      \"directions\": [],\n" +
            "      \"items\": []\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Debug\",\n" +
            "      \"description\": \"Walking back into the forest, you find that around you, there was nothing but a bright white.\\nThe floor appears underneath you with each step as you see an item hovering in the middle.\",\n" +
            "      \"directions\": [],\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemName\": \"Teleporter\",\n" +
            "          \"inventoryName\": \"debugTeleporter\",\n" +
            "          \"toBePrinted\": true,\n" +
            "          \"edible\": false,\n" +
            "          \"description\": \"As you look at the item before you, it glows pink and black. You know it's not supposed to exist, yet somehow it seems right as it magnetically sticks to your hand. Congrats, you're now in debug mode.\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    static String firstInformation = "As you step forward, the sunlight washing over you in a deep golden wave, " +
            "a forest stands in front of you.\n" +
            "The dense woodland forms a natural wall from which you wondered how you managed to " +
            "find your way out of.\n" +
            "Looking back, the shadows seem to grow with each passing moment, looming closer and " +
            "closer as the darkness aims to swallow up the world for another night.\n" +
            "Shuddering, you place the wooded barrier to your back and turn to look " +
            "forward.\n" +
            "You see a natural path cut into the grass before you, diverging just a little" +
            " ways ahead.\n" +
            "From here you can go: East, North, or Northeast\n";

    static String hungerDownInformation = "As you step forward, the sunlight washing over you in a deep golden wave, a forest stands in front of you.\n" +
            "The dense woodland forms a natural wall from which you wondered how you managed to find your way out of.\n" +
            "Looking back, the shadows seem to grow with each passing moment, looming closer and closer as the darkness aims to swallow up the world for another night.\n" +
            "Shuddering, you place the wooded barrier to your back and turn to look forward.\n" +
            "You see a natural path cut into the grass before you, diverging just a little ways ahead.\n" +
            "From here you can go: East, North, or Northeast\n" +
            "Your stomach rumbles. It had been days since you had last eaten. Looking across the landscape, game and fruit seemed to be sparse, and water was out of sight.\n" +
            "Though currently willpower might be enough to hold yourself together, you question how long you might last.";


    static String hungerGameOver = "With each step, your muscles began to cramp as you approach the wooden shack. The sand was not kind to your weary body. Taking a breath, your eyes begin to take in the scene.\n" +
            " A deep blue ocean sat under a pink sky, the golden orb of the sun hanging low in the air as it worked its way down the sky. Sand was piled up against the shack, the windows cracked and the color of the wood faded with time. \n" +
            "Walking up front, the door seemed to be left open, a dusty, dirty home with nothing of value was revealed.\n" +
            "From here you can go: West\n" +
            "As you step forward, you knees buckle underneath you, your strength failing to keep you up as hunger and thirst claw at your mind.\n" +
            "You find your vision slowly growing dark as your body tries to conserve what little energy it has left. As the world fades away, you wonder what else you could have done.\n" +
            "Your game is over.\n" +
            "You took 6 moves this game!";

    static String lookAroundResult = "As you step forward, the sunlight washing over you in a deep golden wave, a forest stands in front of you.\n" +
            "The dense woodland forms a natural wall from which you wondered how you managed to find your way out of.\n" +
            "Looking back, the shadows seem to grow with each passing moment, looming closer and closer as the darkness aims to swallow up the world for another night.\n" +
            "Shuddering, you place the wooded barrier to your back and turn to look forward.\n" +
            "You see a natural path cut into the grass before you, diverging just a little ways ahead.\n" +
            "From here you can go: East, North, or Northeast\n";

    static String commandParserEat = "As you look at the meat, your hunger seems to command your movements as you hungrily devour it.\n" +
            "Not caring much for etiquette or hygiene, it disappears in chunks as you tear off bit by bit and refuel your malnourished body.";

    static String goTestResult = "Your feet begin to sink into the ground with each step as the dirt turns to sand.\n" +
            "Though not unusual terrain, the extra effort to walk on the sandy surface of the beach seems to sap at your strength just a little bit more than the hard ground before. You're faced with the ocean in front of you, the gentle lapping of the waves against the beachhead filling the air with a calming white noise. \n" +
            "Something glints in the sand at your feet.\n" +
            "From here you can go: West, or East\n";

    static String helpCommand = "Commands: \"Pickup ____\",  \"Go ____\", \"Eat ____\", Inventory, \"Look ____\", \"Look around\", and \"Use item with Direction\". You can also exit.";

    static String lookResult = "Looking towards the east, you see the dirt and grass turn to pebbles and sand.\n" +
            "The smell of the sea washes over you, as do the faint sounds of water. It doesn't seem to be too far off.";

    static String pickUpItem = "The shine in the sand catches your eyes.\n" +
            "You crouch down to pick it up. As your hand brushes against the surface, you feel the metal shape of what appears to be a key! The sand falls away revealing a rusted key, scarred by the salty air and the water.";

    static String fromURL = "{  \"startingRoom\": \"TheWoods\",  \"endingRoom\": \"TheCity\",  \"hungerStatus\": [    \"Your stomach rumbles. It had been days since you had last eaten. Looking across the landscape, game and fruit seemed to be sparse, and water was out of sight. \\nThough currently willpower might be enough to hold yourself together, you question how long you might last.\",    \"With each step, your arms and legs seem heavier, your midsection aching as you push yourself forward. \\nThough the thoughts of survival keep the hunger at bay, it gnaws on your will with a persistence that could not be ignored.\",    \"As you step forward, you knees buckle underneath you, your strength failing to keep you up as hunger and thirst claw at your mind. \\nYou find your vision slowly growing dark as your body tries to conserve what little energy it has left. As the world fades away, you wonder what else you could have done.\"  ],  \"player\": {    \"items\": []  },  \"rooms\": [    {      \"name\": \"TheWoods\",      \"description\": \"As you step forward, the sunlight washing over you in a deep golden wave, a forest stands in front of you. \\nThe dense woodland forms a natural wall from which you wondered how you managed to find your way out of. \\nLooking back, the shadows seem to grow with each passing moment, looming closer and closer as the darkness aims to swallow up the world for another night. Shuddering, you place the wooded barrier to your back and turn to look forward. \\n You see a natural path cut into the grass before you, diverging just a little ways ahead.\",      \"directions\": [        {          \"directionName\": \"East\",          \"directionDescription\": \"Looking towards the east, you see the dirt and grass turn to pebbles and sand. \\nThe smell of the sea washes over you, as do the faint sounds of water. It doesn't seem to be too far off.\",          \"room\": \"BeachPath\",          \"enabled\": \"true\",          \"validKeyNames\": []        },        {          \"directionName\": \"North\",          \"directionDescription\": \"As your gaze falls to the North, you see a more defined path, the grass cleared away with intention. \\nPerhaps another being had managed to come here before you? Something faint appears on the horizon over the gentle slope of a small hill.\",          \"room\": \"ForestCabin\",          \"enabled\": \"true\",          \"validKeyNames\": []        },        {          \"directionName\": \"Northeast\",          \"directionDescription\": \"Looking at the middle of the three paths, you see that it cuts through the rolling landscape. \\nWinding between the various small hills, it leads towards a growing set of what could either be defined as a small mountain or a large hill.\",          \"room\": \"Foothill\",          \"enabled\": \"true\",          \"validKeyNames\": []        },        {          \"directionName\": \"Debug\",          \"directionDescription\": \"\",          \"room\": \"Debug\",          \"enabled\": \"true\",          \"hidden\": true,          \"validKeyNames\": []        }      ],      \"items\": []    },    {      \"name\": \"BeachPath\",      \"description\": \"Your feet begin to sink into the ground with each step as the dirt turns to sand. \\nThough not unusual terrain, the extra effort to walk on the sandy surface of the beach seems to sap at your strength just a little bit more than the hard ground before. You're faced with the ocean in front of you, the gentle lapping of the waves against the beachhead filling the air with a calming white noise. \\nSomething glints in the sand at your feet.\",      \"directions\": [        {          \"directionName\": \"West\",          \"directionDescription\": \"Looking back from where you came, you can see the forest in the distance, the small trail that your shoes had left in the sand visible against the golden sun. \",          \"room\": \"TheWoods\",          \"enabled\": \"true\",          \"validKeyNames\": []        },        {          \"directionName\": \"East\",          \"directionDescription\": \"Looking ahead, you see a small shack in the distance. It appears small against the rolling yellow white sand dunes, but prominent. It doesn't seem too far away, perhaps you should check out what's there?\",          \"room\": \"BeachShack\",          \"enabled\": \"true\",          \"validKeyNames\": []        }      ],      \"items\": [        {          \"itemName\": \"shinyObject\",          \"inventoryName\": \"Key\",          \"toBePrinted\": false,          \"edible\": false,          \"description\": \"The shine in the sand catches your eyes. \\nYou crouch down to pick it up. As your hand brushes against the surface, you feel the metal shape of what appears to be a key! The sand falls away revealing a rusted key, scarred by the salty air and the water.\"        }      ]    },    {      \"name\": \"BeachShack\",      \"description\": \"With each step, your muscles began to cramp as you approach the wooden shack. The sand was not kind to your weary body. Taking a breath, your eyes begin to take in the scene.\\n A deep blue ocean sat under a pink sky, the golden orb of the sun hanging low in the air as it worked its way down the sky. Sand was piled up against the shack, the windows cracked and the color of the wood faded with time. \\nWalking up front, the door seemed to be left open, a dusty, dirty home with nothing of value was revealed.\",      \"directions\": [        {          \"directionName\": \"West\",          \"directionDescription\": \"With malice, you look back at where you came from, the forest now blurred by the fog of distance. Your legs cramp up as you think about the walk you would have to take to go back to that dirty path.\",          \"room\": \"BeachPath\",          \"enabled\": \"true\",          \"validKeyNames\": []        }      ],      \"items\": []    },    {      \"name\": \"ForestCabin\",      \"description\": \"As you step over the hill, a house reveals itself to you. A nice dark wood frames the home, a picturesque hut with the sun shining on the felled timber. The area around it had the marks of being maintained but since overgrown. As you approach the cabin, you see pieces of felled lumber stacked up beside it and spent coals in a pit beside a spit roast. Standing in front of it presents you with a door, a thick metal padlock worn and rusted by the passage of time denying you entry to what might be inside.\",      \"directions\": [        {          \"directionName\": \"Inside\",          \"directionDescription\": \"Looking through the window of the cabin, you can vaguely make out some basic shapes. The glass isn't very conducive to peeping.\",          \"room\": \"FoodRoom\",          \"enabled\": \"false\",          \"validKeyNames\": [            \"shinyObject\"          ]        },        {          \"directionName\": \"South\",          \"directionDescription\": \"Looking behind you, you see the forest curve off and the water faintly twinkle on the horizon. The faint rays of light of the quickly ending day highlight a scene that would be enjoyable to just sit and watch had you not been on the brink of starvation.\",          \"room\": \"TheWoods\",          \"enabled\":\"true\",          \"validKeyNames\": []        }      ],      \"items\": []    },    {      \"name\": \"FoodRoom\",      \"description\": \"Entering the cabin presents you with an interior devoid of much of anything. A worn axe laid off to the side, chipped and broken. \\nIt seemed to be abandoned for all you could tell. Looking at the table, you're presented with a worn photo of a family with faded faces. Suddenly, the sharp smell of meat hits your nose. Turning back, behind the door, you see a cooked slab of meat. It seems tantalizing, the aroma overpowering.\",      \"directions\": [        {          \"directionName\": \"Outside\",          \"directionDescription\": \"It's outside. You look out the door to see where you just came in from. Nothing new, other than the sun slightly lower than where it was, the gold rays dimming as time marched forward.\",          \"room\": \"ForestCabin\",          \"enabled\": \"true\",          \"validKeyNames\":[]        }      ],      \"items\": [        {          \"itemName\": \"sliceOfMeat\",          \"inventoryName\": \"Meat\",          \"toBePrinted\": true,          \"edible\": true,          \"description\": \"As you look at the meat, your hunger seems to command your movements as you hungrily devour it. Not caring much for etiquette or hygiene, it disappears in chunks as you tear off bit by bit and refuel your malnourished body.\"        }      ]    },    {      \"name\": \"Foothill\",      \"description\": \"Foothill_DESC\",      \"directions\": [        {          \"directionName\": \"Southwest\",          \"directionDescription\": \"BackToForest\",          \"room\": \"TheWoods\",          \"enabled\": \"true\",          \"validKeyNames\": []        },        {          \"directionName\": \"Northeast\",          \"directionDescription\": \"Into the mountains\",          \"room\": \"MountainPass\",          \"enabled:\": \"true\",          \"validKeyNames\": []        }      ],      \"items\": []    },    {      \"name\": \"MountainPass\",      \"description\": \"MountainDesc\",      \"directions\": [        {          \"directionName\": \"Left\",          \"directionDescription\": \"ripuded\",          \"room\": \"TheFall\",          \"enabled\": \"true\",          \"validKeyNames\": []        },        {          \"directionName\": \"Right\",          \"directionDescription\":\"towards safety\",          \"room\": \"PathToCity\",          \"enabled\": \"true\",          \"validKeyNames\": []        }      ],      \"items\": []    },    {      \"name\": \"TheFall\",      \"description\": \"OhNoYouSlipped\",      \"directions\": [        {          \"directionName\": \"Left\",          \"directionDescription\": \"ripuded\",          \"room\": \"Death\",          \"enabled\": \"true\",          \"validKeyNames\": []        },        {          \"directionName\": \"Right\",          \"directionDescription\":\"brokenLegsButokay\",          \"room\": \"PathToCity\",          \"enabled\": \"true\",          \"validKeyNames\": []        }      ],      \"items\": []    },    {      \"name\": \"Death\",      \"description\": \"RIPINPIECES\",      \"directions\": [],      \"items\": []    },    {      \"name\": \"PathToCity\",      \"description\": \"CityAhead\",      \"directions\": [        {          \"directionName\": \"Southwest\",          \"directionDescription\": \"Why would you go back to the mountains\",          \"room\": \"MountainPass\",          \"enabled\": \"true\",          \"validKeyNames\": []        },        {          \"directionName\": \"Northeast\",          \"directionDescription\":\"ay look its the city\",          \"room\": \"TheCity\",          \"enabled\": \"true\",          \"validKeyNames\": []        }      ],      \"items\": []    },    {      \"name\": \"TheCity\",      \"description\": \"YouMadeIt!\",      \"directions\": [],      \"items\": []    },    {      \"name\": \"Debug\",      \"description\": \"DebugMenu\",      \"directions\": [],      \"items\": [        {          \"itemName\": \"Teleporter\",          \"inventoryName\": \"debugTeleporter\",          \"toBePrinted\": true,          \"edible\": false,          \"description\": \"As you look at the item before you, it glows pink and black. You know it's not supposed to exist, yet somehow it seems right as it magnetically sticks to your hand. Congrats, you're now in debug mode. .\"        }      ]    }  ]}";

    static String roomNames = "This is not a valid room nameRoom in this game: TheWoods, BeachPath, BeachShack, ForestCabin, FoodRoom, Foothill, MountainPass, TheFall, Death, PathToCity, TheCity, Debug, ";

    static String teleporterGetDesc = "As you step forward, the sunlight washing over you in a deep golden wave, a forest stands in front of you.\n" +
            "The dense woodland forms a natural wall from which you wondered how you managed to find your way out of.\n" +
            "Looking back, the shadows seem to grow with each passing moment, looming closer and closer as the darkness aims to swallow up the world for another night.\n" +
            "Shuddering, you place the wooded barrier to your back and turn to look forward.\n" +
            "You see a natural path cut into the grass before you, diverging just a little ways ahead.\n" +
            "From here you can go: East, North, or Northeast\n";

    static String wholeGame = "You find yourself entering the city just as the first street lamps were flickering on. With the sun now firmly below the horizon, you see the purple of night overtake the sky rapidly.\n" +
            "Gasping a sigh of relief, the shadows of buildings, and the flickering of fires indoors all provide a sense of security as you see people once more, bustling around you.\n" +
            "The scents and sounds of civilization were overwhelming as you hobble down the cobblestone streets, but reassuring.\n" +
            "You're home.\n" +
            "\n" +
            "Your game is over.\n" +
            "You took 10 moves this game!";

    static String deathGame = "As you try to curl yourself up and shift your weight to the left, you feel a snaking branch crack against your back, forcing you open.\n" +
            "A rock hits your head, and you fall limp to the ground as your livelihood is drained fromn your body. Weak from hunger, you could do nothing but lay there as your senses slowly leave you, darkness washing over the landscape as you draw your final breath.\n" +
            "\n" +
            "Your game is over.\n" +
            "You took 10 moves this game!";

    static String JSON_WITHOUT_LINEBREAKS = MY_ADVENTURE_JSON.replaceAll("\n", "").replaceAll("\r", "");
}
