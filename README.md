# igentifySmallSanity
This repository contains automation tests examples for igentify website platform.

This infrastructure contains an extended basic class (called Base) where objects for all platforms are created.  Following that, it contains an extended class called CommonsOps, where the objects are initialized for all platforms.

From here, all others classes in the infrastructure and business levels inherit from CommonOps class.

This makes this project very modular, whith an effective separation between infrastructure and test cases modules.
