# APSWatchdog
An Independent app to monitor if AndroidAPS stops running

## Introduction
AndroidAPS will occasionally crash without notifying the user. This can be especially annoying if a temp basel of 0 was just set and it crashes before issuing SMBs, resulting in no insulin for 30+ minutes. 

## How it Works
AndroidAPS frequently sends out broadcast messages just about any time it does anything (ie every 5 minutes when receiving a new BG). 

Upon receiving the first broadcast (and any subsequent broadcast) a 12 minute alarm is set/reset. If 12 minutes go by without receiving anything from AndroidAPS this will trigger a notification. 
